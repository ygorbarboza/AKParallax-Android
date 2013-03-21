AKParallax-Android 
================

AKParallax-Android  is a Library Project that provide a parallax effect to a imageView in a ParallaxScrollView.

## Usage

* Import the app folder as a Android project. The .project included will cause it to have the name `Parallax`.

### In your activity xml

``` xml

  <net.appkraft.parallax.ParallaxScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/scrollView1"
    android:layout_width="match_parent" android:overScrollMode="never"
    android:layout_height="match_parent" > 

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="1000dp"
        tools:context=".MainActivity" >

        <ImageView
            android:id="@+id/imageView1"
            android:layout_width="match_parent"
            android:layout_height="100dp"
            android:src="@drawable/teste" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentLeft="true"
            android:layout_below="@+id/imageView1"
            android:text="@string/hello_world" />

    </RelativeLayout>

</net.appkraft.parallax.ParallaxScrollView>

```

### In your code

Setting the imageView that will do the parallax effect:

``` java
  protected void onCreate(Bundle savedInstanceState) {

		parallax.setImageViewToParallax(imageView);

	}
```
Setting zoom ratio of the parallax and getting the sizes of the view:

``` java
  @Override
	public void onWindowFocusChanged(boolean hasFocus) {

		super.onWindowFocusChanged(hasFocus);

		parallax.setViewsBounds(parallax.NO_ZOOM);

	}
```
