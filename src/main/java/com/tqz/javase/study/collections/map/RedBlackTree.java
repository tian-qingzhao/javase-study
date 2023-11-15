package com.tqz.javase.study.collections.map;

/**
 * 手写红黑树
 *
 * @author tianqingzhao
 * @since 2023-06-23 11:08
 */
public class RedBlackTree {

    class Node {
        /**
         * 节点内容值
         */
        private int value;

        /**
         * 节点颜色
         */
        private String color;

        /**
         * 左子树
         */
        private Node left;

        /**
         * 右子树
         */
        private Node right;

        /**
         * 记录当前节点父节点
         */
        private Node parent;

        public Node(int value, String color, Node left, Node right, Node parent) {
            super();
            this.value = value;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node() {
            super();
        }

        @Override
        public String toString() {
            return "Node [value=" + value + ", color=" + color + ", left=" + left + ", right=" + right + ", parent="
                    + parent + "]";
        }
    }

    //记录根节点
    private Node root;

    /**
     * 添加节点
     *
     * @param value
     * @return
     */
    public Node add(int value) {
        //当根节点为null时,新插入的节点就是跟节点
        if (root == null) {
            Node node = new Node(value, "black", null, null, null);
            root = node;
            return node;
        } else {
            //当根节点不为空时,从根节点开始,搜索二叉树,得到新节点要插入的位置,并插入新节点
            Node node = getPosition(root, value);
            //红黑树修复
            repairTree(node);
            return node;
        }
    }

    /**
     * 红黑树修复
     *
     * @param node
     */
    private void repairTree(Node node) {
        //如果父节点为红色,当前节点默认红色,两红相连,变色或者旋转
        if (node.parent.color.equals("red") && node.color.equals("red")) {
            //父节点
            Node p = node.parent;
            Node g = node.parent.parent;
            //如果叔叔节点和父亲节点都为红,变色操作:将父亲节点+叔叔节点改为黑,祖父节点改为红
            //假设当前为右子树,叔叔在左边
            if (g.left != null && g.left.color.equals("red")) {
                p.color = "black";
                g.left.color = "black";
                //如果祖父节点为根节点
                if (g == root) {
                    g.color = "black";
                } else {
                    g.color = "red";
                }
                return;
            }

            //否则旋转
            leftRotate(g);
            //左旋后祖父节点变为红色,父亲节点变成黑色
            g.color = "red";
            p.color = "black";
        }
    }

    /**
     * 左旋
     *
     * @param x
     */
    private void leftRotate(Node x) {
        //通过待翻下的x,获取待翻上的y
        Node y = x.right;
        //改变x和y.left的执行
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        //改变父节点指向
        y.parent = x.parent;
        if (x.parent == null) {
            // x为根节点，x翻下y翻上，y变为新根节点
            root = y;
        } else {
            // 否则，判断x为左子树或者右子树，分别做不同的处理
            if (x.parent.left == x) {
                // x为左子树，父节点的左子树变为y
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        // 更改x和y之间的指向关系
        y.left = x;
        x.parent = y;
    }

    /**
     * 遍历二叉树,把新节点添加到二叉树的末尾
     *
     * @param node
     * @param value
     * @return
     */
    private Node getPosition(Node node, int value) {
        if (value > node.value) {
            //插入右子树
            if (node.right == null) {
                Node newNode = new Node(value, "red", null, null, node);
                node.right = newNode;
                return newNode;
            } else {
                return getPosition(node.right, value);
            }
        } else {
            //插入左子树
            if (node.left == null) {
                Node newNode = new Node(value, "red", null, null, node);
                node.left = newNode;
                return newNode;
            } else {
                return getPosition(node.left, value);
            }
        }
    }

}