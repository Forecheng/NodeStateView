# NodeStateView
Marker task state or progress by using node<br>
A simple example that using Jitpack.io<br><br>
[![](https://jitpack.io/v/Forecheng/NodeStateView.svg)](https://jitpack.io/#Forecheng/NodeStateView)


----------


## Preview

![组件截图预览][1]

## Dependency

**Step 1:** Add it in your root build.gradle at the end of repositories:
``` java
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
**Step 2:**Add the dependency

``` java
dependencies {
	        compile 'com.github.Forecheng:NodeStateView:0.0.1'
	}
```


----------
## Usage
add widget in your layout.xml

```java
 <com.example.nodestatelibrary.NodeStateView
        android:id="@+id/nodeState1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

    </com.example.nodestatelibrary.NodeStateView>
    
    
stateView1 = (NodeStateView) findViewById(R.id.nodeState1);
stateView1.setNodeProgressByStatus(1); //set status enum value
stateView3.setNodeProgressByStatus(4); stateView3.setDownBackgroundColor(this,R.color.nice_color);
stateView3.setUpBackgroundColor(this,R.color.colorAccent);
```
***我们虽平凡，<br>
但不平庸，<br>
做一个能不停告诉自己前进的人，<br>
一步一个脚印向前！***



  [1]: ./screenshot/image2.png
