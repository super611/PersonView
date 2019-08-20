# PersonView
## Android沉浸式状态栏+图片背景+标题栏渐变+背景伸缩
首先是自定义ScrollView实现Toolbar（标题栏）渐变

效果展示图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019081313080726.gif)
编程思想：

1、自定义一个类，继承自ScrollView，并重写它的 onScrollChanged 方法；

2、在 onScrollChanged 中获取 ScrollView 在Y轴的移动距离，并根据此距离改变 Toolbar(标题栏) 的透明度。
