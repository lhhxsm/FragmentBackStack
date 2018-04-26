# Fragment的回退栈
----------
1.原生的回退栈会使得Fragment之间显示产生叠层  addToBackStack(null) 不符合我们的需求。  

2.实现原理是存储Fragment，使其最后添加Fragment在栈顶。