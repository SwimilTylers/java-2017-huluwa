# java-2017-huluwa
One Java Project for Java-Programming, 2017f of NJU.
 
A simulation of Huluwa, Description for detailed infomation.

Designed and coded by _Swimiltylers_, a NJU undergraduate-to-be.

If you are interested, please e-mail me.

Thank you!

## Description
葫芦娃有七兄弟（没看过的请参考[豆瓣](https://movie.douban.com/subject/1428576/)）。红娃排行老大、橙娃排行老二、黄娃排行老三、绿娃排行老四、青娃排行老五、蓝娃排行老六、紫娃排行老七，七兄弟各有一身独特的本领。

![葫芦兄弟](http://english.cri.cn/mmsource/images/2009/06/24/4634carton1.jpg)

请用**面向对象编程方法**，以Java语言编写程序，实现以下过程：
1. 先让七个兄弟随意站队，然后让他们按冒泡法依照各自排行（从老大到老七）进行排序，排序结束从第一个到最后一个报数（如老大报“老大”，以此类推）；
2. 然后让七兄弟再次随意站队，然后用让他们按二分法依照各自颜色（赤橙黄绿青蓝紫）进行排序，排序结束从第一个到最后一个报颜色（如老大报“红色”，以此类推）；
3. 排序过程中，每个葫芦娃在每次交换位置的时候报告交换动作（例如老大从位置5换至位置6，报告“老大：5->6“）

完成后按照作业提交要求和流程，完成作业提交。

## Design
Huluwa is an abstract-class, which modifies the 
inteface of those Huluwas. Based on OOP, I will mimic the
nature process of the action of Huluwas. 