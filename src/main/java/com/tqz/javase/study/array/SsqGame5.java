package com.tqz.javase.study.array;

import java.util.Scanner;

public class SsqGame5 {
	public static void main(String[] args) {
		int totalMoney = 0; //下注总费用 
		int price = 2; //双色球单价每注2元 
		int count=0;//购买了彩票的注数
		boolean isBuy = false; //标识是否购买了彩票
		int num[]=null;//存储双色球号
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("");
			System.out.println("*****欢迎进入双色球彩票系统*****");
			System.out.println("\t1.购买彩票");
			System.out.println("\t2.查看开奖");
			System.out.println("\t3.退出");
			System.out.println("***************************");
			System.out.print("请选择菜单：");
			
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				//购买彩票
				System.out.println("[双色球彩票系统 > 购买彩票]");
				System.out.println("您需要下多少注？：");
				count = input.nextInt();//买了多少注
				totalMoney=count*price;//总下注钱数
				
				//开始选号（6个红色球号和1个蓝色球号）
				num=new int[7];//用来存储双色球号--》6红+1蓝
				for(int i=0;i<num.length;i++){
					int red;//输入的红球数字
					int blue;//输入的蓝球数字
					if(i<num.length-1){//选红号
						System.out.println("请输入6个红色球号(数字为1-33)，第【"+(i+1)+"】个红色球号为：");
						red=input.nextInt(33);
						num[i]=red;//将红号放入数组num中
					}else{//选蓝号
						System.out.println("请输入1个蓝色球号(数字为1-16)：");
						blue=input.nextInt(16);
						num[i]=blue;
					}
				}				
				//输出已买好的彩票信息
				System.out.print("您一共买了【"+count+"】注，共需支付【"+totalMoney+"】元，所选号为：");
				for(int i=0;i<num.length;i++){
					System.out.print(num[i]+"\t");
				}
				System.out.println();//换行输出
				isBuy = true; //成功购买双色球彩票，标志位设置为true				
				break;
			case 2:
				System.out.println("[双色球彩票系统 > 查看开奖]");
				if (isBuy) {//判断是否购买了彩票
					//
					isBuy = false;
					//调用getLuckNum方法得到一个随机中奖号					
					int luckNum[]=getLuckNum();
					//输出你已买的彩票号
					System.out.print("已买的彩票号为：");
					for(int n:num){
						System.out.print(n+"\t");
					}
					System.out.println();//换行
					
					//输出当期的中奖号
					System.out.print("当期的中奖号为：");
					for(int n:luckNum){
						System.out.print(n+"\t");
					}
					System.out.println();//换行
					
					//判断获奖等级
					int result=getCompareResult(num,luckNum);					
					//根据获奖等级输出结果					
					if(result==1){
						System.out.println("【一等奖】,恭喜你!!共下了【"+count+"】注,投资【"+totalMoney+"】元,获奖【"+(500*count)+"】万元");
					}else if(result==2){
						System.out.println("【二等奖】,恭喜你!!共下了【"+count+"】注,投资【"+totalMoney+"】元,获奖【"+(400*count)+"】万元");
					}else if(result==3){
						System.out.println("【三等奖】,恭喜你!!共下了【"+count+"】注,投资【"+totalMoney+"】元,获奖【"+(300*count)+"】万元");
					}else if(result==4){
						System.out.println("【四等奖】,恭喜你!!共下了【"+count+"】注,投资【"+totalMoney+"】元,获奖【"+(200*count)+"】万元");
					}else if(result==5){
						System.out.println("【五等奖】,恭喜你!!共下了【"+count+"】注,投资【"+totalMoney+"】元,获奖【"+(100*count)+"】万元");
					}else if(result==6){
						System.out.println("【六等奖】,恭喜你!!共下了【"+count+"】注,投资【"+totalMoney+"】元,获奖【"+(5*count)+"】元");
					}else{
						System.out.println("【望再接再厉】,sorry!!共下了【"+count+"】注,投资【"+totalMoney+"】元,获奖【"+(0*count)+"】元");
					}
				} else {
					System.out.println("请先购买彩票，再查看开奖情况！");
				}
				break;
			case 3:
				System.out.println("谢谢使用");
				return;
			default:
				System.out.println("输入错误");

			}
		}while(true);
		
	}
	
	/**
	 * 随机生成一个中奖号
	 * @return
	 */
	public static int[] getLuckNum(){
		int luckNum[]=new int[7];
		for(int i=0;i<luckNum.length;i++){
			if(i<luckNum.length-1){//红球
				luckNum[i]=(int)(Math.random()*33)+1;//生成一个1-33的随机数
			}else{//蓝球
				luckNum[i]=(int)(Math.random()*16)+1;//生成一个1-16的随机数
			}
		}
		return luckNum;
	}
	
	
	/**
	 * 计算获奖等级
	 * @param num  所买彩票号
	 * @param luckNum  当期中奖号
	 * @return
	 */
	public static int getCompareResult(int num[],int luckNum[]){
		//查看自己中奖情况
		int luckLevel=0;//中奖等级1-6
		int redEqualCount=0;//红球相等数量
		int blueEqualCount=0;//蓝球相等数量
		
		//将自己的彩票号与开奖号进行比较
		for(int i=0;i<num.length;i++){
			if(i<num.length-1){
		    //比较红球==自己买的彩票的红球号与中奖的红球号进行比较
			  int r=num[i];//每遍历一次将自己的一个红球号与中奖的所有红球号进行比较
		      for(int j=0;j<luckNum.length-1;j++){
				if(r==luckNum[j]){
					redEqualCount++;
				}
			  }	
			}else{
		    //比较蓝球==自己买的彩票的蓝球号与中奖的蓝球号进行比较
			 if(num[num.length-1]==luckNum[luckNum.length-1]){
				 blueEqualCount++;
			 }
			}
		}
		
		//得出结果
		if(redEqualCount==6&&blueEqualCount==1){//一等奖  红球与蓝球都同
			luckLevel=1;			
		}else if(redEqualCount==6){//二等奖  6红同
			luckLevel=2;			
		}else if(redEqualCount==5&&blueEqualCount==1){//三等奖  5红同和1蓝同
			luckLevel=3;		
		}else if((redEqualCount==5)||(redEqualCount==4&&blueEqualCount==1)){//四等奖 5红同或 4红同和1蓝同
			luckLevel=4;			
		}else if((redEqualCount==4)||(redEqualCount==3&&blueEqualCount==1)){//五等奖 4红同或 3红同和1蓝同
			luckLevel=5;			
		}else if(blueEqualCount==1){//六等奖  蓝球同
			luckLevel=6;			
		}
		return luckLevel;
	}
}