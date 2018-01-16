# ThirdPartyLibrariesStudy
## 1、仿饿了么加入购物车旋转控件
GitHub：[https://github.com/mcxtzhang/AnimShopButton](https://github.com/mcxtzhang/AnimShopButton)
这个我在自己的项目里面用上了，但是有两点不足：

1. 商品数量字体不能改变颜色；
2. 不能设置最小数量。

## 2、PasscodeView：一个简单的密码设置和输入界面
GitHub：[https://github.com/hanks-zyh/PasscodeView](https://github.com/hanks-zyh/PasscodeView)
这个控件一共有两种模式：设置密码和验证密码，由属性`passcodeViewType`解决。值为`set_passcode`时是设置密码模式，需要输入密码两次；`check_passcode`则表示是验证密码模式，需要在本地设置好密码。

个人觉得这个库用处不大，特别是验证密码的监听事件，一般情况是将用户填好的密码传给服务器，由服务器来判断是否正确，而不是在本地获取。

## 3、AutoSystemBar
一句代码适配4.4以上沉浸状态栏和沉浸导航栏一句代码适配4.4以上沉浸状态栏和沉浸导航栏。
GitHub：[https://github.com/lliuguangbo/AutoSystemBar](https://github.com/lliuguangbo/AutoSystemBar)

不知道为什么，我这里没有起作用。

## 4、CountdownView:倒计时控件
GitHub：[https://github.com/iwgang/CountdownView](https://github.com/iwgang/CountdownView)
非常好用，我在自己的项目里用上了。属性众多，相信能满足绝大多数的需求了。这里有几个小效果可以记录一下：
### 4.1 动态修改倒计时的单位
倒计时的时间比较长时，我们可以设置单位为“天-时-分”，当倒计时的时间小于24小时后，可以修改配置，将单位改为“天-时-秒”。
```java
    private DynamicConfig setDynamicConfig(long remainTime) {
        DynamicConfig.Builder dynamicConfigBuilder = new DynamicConfig.Builder();
        dynamicConfigBuilder.setShowHour(true);
        dynamicConfigBuilder.setShowMinute(true);
        //判斷天數是否為0
        isShowDay = (remainTime / (1000 * 60 * 60 * 24)) > 0;
        if (isShowDay) {
            dynamicConfigBuilder.setShowDay(true);
            dynamicConfigBuilder.setShowSecond(false);
            dynamicConfigBuilder.setShowMillisecond(false);
        } else {
            dynamicConfigBuilder.setShowDay(false);
            dynamicConfigBuilder.setShowSecond(true);
            dynamicConfigBuilder.setShowMillisecond(false);
        }

        return dynamicConfigBuilder.build();
    }
```
那么什么时候知道剩余时间小于24小时呢？CountdownView提供了一个倒计时监听，监听的间隔可以自由设置，这里设置为1秒就可以了。
```java
                    countdownView.setOnCountdownIntervalListener(1000, new CountdownView.OnCountdownIntervalListener() {
                        @Override
                        public void onInterval(CountdownView cv, long remainTime) {
                            if (countdownView.getDay() <= 0) {
                                //剩余时间小于24小时，重新设置单位
                                countdownView.dynamicShow(setDynamicConfig(remainTime));
                                isShowDay = false;
                            }
                        }
                    });
```
### 4.2 倒计时完成之后隐藏倒计时控件
倒计时完成之后我们可能需要隐藏倒计时控件，这个也很简单，CountdownView可以监听倒计时结束：
```java
                countdownView.setOnCountdownEndListener(new CountdownView.OnCountdownEndListener() {
                    @Override
                    public void onEnd(CountdownView cv) {
                        
                    }
                });
```

## 5、CheckVersionLib:版本更新
GitHub：[https://github.com/AlexLiuSheng/CheckVersionLib](https://github.com/AlexLiuSheng/CheckVersionLib)
这个库我写了一个Demo，基本的效果都实现了，但还不确定会不会用在自己的项目里。

目前主要有下面几个问题：
1. 1.8.7版本的targetVersion版本需要27，否则会报27.0.0的错误，所以我目前用的是1.8.3版本，但该版本好像没有兼容Android8.0.
2. 设置强制更新后，默认的更新对话框还有取消按钮，而且点击后对话框消失，没有起到强制的作用。所以我采用了自定义更新提醒对话框。

## 6、NumberProgressBar
一个带数字的ProgressBar，用法跟ContentProgressBar差不多，简单易用。
GitHub:[https://github.com/daimajia/NumberProgressBar](https://github.com/daimajia/NumberProgressBar)

## 7、MaterialEditText
GitHub：[https://github.com/rengwuxian/MaterialEditText](https://github.com/rengwuxian/MaterialEditText)

挺不错的一个MD风格的EditText，作者是知名的开发者扔物线。试着用了一下，可以实现的效果很多，但是目前发现有一点不足：ClearButton的样式不能更换。

这个在实际项目中不知道能不能用上，毕竟UI总是说要跟iOS的保持一致……



