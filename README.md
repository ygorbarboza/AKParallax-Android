AKParallax-Android 
================

AKParallax-Android  is a Library Project that provides a parallax effect to an imageView in a ParallaxScrollView.

## Usage

* Import the app folder as an Android project. The .project included will cause it to have the name `Parallax`.

### In your activity xml

``` xml

  <net.appkraft.parallax.ParallaxScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res/com.appkraft.parallax_sample"
    android:id="@+id/scrollView1"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:overScrollMode="never"
    app:zoomRatio="1.4" >

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="1000dp"
        tools:context=".MainActivity" >

        <RelativeLayout
            android:id="@+id/relativeLayout1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            tools:context=".MainActivity" >

            <ImageView
                android:id="@+id/imageView1"
                android:layout_width="match_parent"
                android:layout_height="100dp"
                android:src="@drawable/teste" />

            <TextView
                android:id="@+id/textView1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentBottom="true"
                android:layout_alignParentLeft="true"
                android:text="Bottom"
                android:textColor="#ffffff"
                android:textSize="18sp" />

            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_alignParentLeft="true"
                android:layout_alignParentTop="true"
                android:text="Top"
                android:textColor="#ffffff"
                android:textSize="18sp" />
        </RelativeLayout>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentLeft="true"
            android:layout_below="@+id/relativeLayout1"
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
Setting zoom ratio of the parallax :

``` java
  protected void onCreate(Bundle savedInstanceState) {

		parallax.setImageViewToParallax(imageView);
		parallax.setViewsBounds(1.3);

	}
```
