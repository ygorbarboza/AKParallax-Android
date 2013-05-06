AKParallax-Android 
================

AKParallax-Android  is a Library Project that provides a parallax effect to an imageView in a ParallaxScrollView.

## Usage

* Import the app folder as an Android project. The .project included will cause it to have the name `Parallax`.

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
Setting zoom ratio of the parallax and getting view sizes:

``` java
  @Override
	public void onWindowFocusChanged(boolean hasFocus) {

		super.onWindowFocusChanged(hasFocus);

		parallax.setViewsBounds(parallax.NO_ZOOM);

	}
```

Sample
----

The sample application (the source is in the repository) has been published onto Google Play for easy access:

<a href="https://play.google.com/store/apps/details?id=com.appkraft.parallax_sample">
  <img alt="Android app on Google Play"
       src="https://developer.android.com/images/brand/en_app_rgb_wo_60.png" />
</a>

License
----

Copyright (C) 2013 Appkraft
http://www.appkraft.net

The MIT License (MIT)

Copyright (c) <year> <copyright holders>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
