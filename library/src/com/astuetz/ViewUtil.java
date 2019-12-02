package com.astuetz;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by xukunn on 2019/12/2.
 * description :
 */
public class ViewUtil {
  /**
   * 获取屏幕宽高
   */
  public static Point getScreenSize(Context context) {
    WindowManager windowManager =
        (WindowManager) context.getSystemService(Context.
            WINDOW_SERVICE);
    final Display display = windowManager.getDefaultDisplay();
    Point outPoint = new Point();
    if (Build.VERSION.SDK_INT >= 19) {
      // 可能有虚拟按键的情况
      display.getRealSize(outPoint);
    } else {
      // 不可能有虚拟按键
      display.getSize(outPoint);
    }
    return outPoint;
  }

  /**
   * 获取View的中心点坐标
   */
  public static int[] getViewCenter(View v) {
    int[] location = new int[2];
    v.getLocationOnScreen(location);
    location[0] = location[0] + v.getWidth() / 2;
    location[1] = location[1] + v.getHeight() / 2;
    return location;
  }
}
