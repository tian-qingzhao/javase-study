package com.tqz.javase.study.collections.map;

/**
 * @author tianqingzhao
 * @since 2023-06-23 11:09
 */
public class RedBlackTree2 {

    /**
     * 当前的根节点
     */
    public Node root;

    class Node {
        /**
         * 节点的内容值
         */
        private int value;
        /**
         * 左节点
         */
        private Node left;
        /**
         * 右节点
         */
        private Node right;
        /**
         * 节点颜色
         */
        private NodeColor color;
        /**
         * 记录当前节点的父亲
         * 没有父亲的情况下肯定事根节点
         * 祖父事Node.parent.parent
         */
        private Node parent;

    }

    //添加节点
    public void insert(int value) {
        if (root == null) {//添加根节点
            Node newNode = new Node();
            //父节点的parent为空
            newNode.parent = null;
            //根节点为黑色
            newNode.color = NodeColor.black;
            //设置根节点值
            newNode.value = value;
            //指定根节点
            root = newNode;
        } else {
            //添加节点
            Node node = insertValue(value);
            //检查节点（修复旋转）
            repairTree(node);
        }

    }

    //插入
    public Node insertValue(int value) {
        return getPosition(root, value);
    }

    //修复红黑树
    public void repairTree(Node newNode) {
        if (newNode.parent.color.equals(NodeColor.red)) {
            //如果红红相 进行修复

            //当前节 点与父亲结点都为红色，且叔叔节点为红色 开始变色，爷爷下的两个子节点都变成黑色
            if ((newNode.parent.parent.left != null && NodeColor.red.equals(newNode.parent.parent.left.color))) {
                //叔叔节点改为黑色
                newNode.parent.parent.left.color = NodeColor.black;
                newNode.parent.color = NodeColor.black;
                if (newNode.parent.parent != root) {//爷爷节点不为根节点则变为红色
                    newNode.parent.parent.color = NodeColor.red;
                }
                return;
            }
            //左旋
            //父亲节点与当前节点都是红色的情况下，且叔叔节点为黑色或者为空的情况下并且当前节点在右子树才开始左旋
            if ((newNode.parent.parent.left == null || NodeColor.black.equals(newNode.parent.parent.color) &&
                    newNode.parent.right == newNode)) {
                leftRotate(newNode.parent.parent);//新节点的爷爷节点是旋转坐标
                //旋转完还要修复颜色 祖宗变红色，父亲变黑色
                changeColor(newNode);
            }

            //右旋
            //父亲节点与当前节点都是红色的情况下，且叔叔节点为黑色或者为空的情况下并且当前节点在左子树才开始右旋
            if ((newNode.parent.parent.right == null || NodeColor.black.equals(newNode.parent.parent.color) &&
                    newNode.parent.left == newNode)) {
                rightRotate(newNode.parent.parent);//新节点的爷爷节点是旋转坐标
                //旋转完还要修复颜色 祖宗变红色，父亲变黑色
                newNode.parent.parent.color = NodeColor.red;
                newNode.parent.color = NodeColor.black;
                //旋转玩也需要变色
                changeColor(newNode);
            }
        }
    }

    public void changeColor(Node newNode) {
        newNode.parent.parent.color = NodeColor.red;
        newNode.parent.color = NodeColor.black;
        if (newNode.parent.color == NodeColor.red) {// 1 2 3 当插入4 旋转完会有bug 还得去判断改变颜色
            newNode.parent.color = NodeColor.black;
            newNode.parent.parent.color = NodeColor.black;
        }
    }

    //左旋
    public void leftRotate(Node node) {
        //node是旋转 坐标
        Node newNode = node.right;
        //旋转之后
        node.right = newNode.left;
        //改变冲突节点左子树的引用
        if (newNode.left != null) {
            newNode.parent = node;
        }
        if (node.parent == null) {
            root = newNode;
        } else {
            if (node.parent.left == node) {//判断是不是左子树
                node.parent.left = newNode;//修改引用关系
            } else {
                node.parent.right = newNode;
            }
        }
        // 修改上位节点的左子树
        newNode.left = node;
        //旋转坐标节点的父亲等于冲突的节点
        node.parent = newNode;
    }

    //右旋
    public void rightRotate(Node node) {
        //node是旋转 坐标
        Node newNode = node.left;
        //旋转之后
        node.left = newNode.right;
        //改变冲突节点左子树的引用
        if (newNode.right != null) {
            newNode.parent = node;
        }
        if (node.parent == null) {
            root = newNode;
        } else {
            if (node.parent.right == node) {//判断是不是右子树
                node.parent.right = newNode;//修改引用关系
            } else {
                node.parent.left = newNode;
            }
        }
        // 修改上位节点的右子树
        newNode.right = node;
        //旋转坐标节点的父亲等于冲突的节点
        node.parent = newNode;
    }

    public Node getPosition(Node node, int value) {
        if (value > node.value) {//往右子树添加
            if (node.right == null) {//等于空去赋值添加
                Node newNode = new Node();
                //父节点的parent为空
                newNode.parent = node;
                //当前节点默认情况为红色
                newNode.color = NodeColor.red;
                //设置节点值
                newNode.value = value;
                //设置父亲节点的右节点
                return node.right = newNode;
            } else {
                return getPosition(node.right, value);
            }
        } else {//往左子树添加
            if (node.left == null) {
                Node newNode = new Node();
                //父节点的parent为空
                newNode.parent = node;
                //当前节点默认情况为红色
                newNode.color = NodeColor.red;
                //设置节点值
                newNode.value = value;
                //设置父亲节点的左节点
                return node.left = newNode;
            } else {
                return getPosition(node.left, value);
            }
        }
    }

    //getMax获取红黑树的最大值
    public Integer getMax(Node root) {
        if (root != null) {
            if (root.right != null) {
                getMax(root.right);
            } else {
                return root.value;
            }
        }
        return null;
    }

    //getMax获取红黑树的最大值
    public Integer getMin(Node root) {
        if (root != null) {
            if (root.left != null) {
                getMax(root.left);
            } else {
                return root.value;
            }
        }
        return null;
    }
}
