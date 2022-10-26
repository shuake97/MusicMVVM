package com.zww.music_mvvm;

import android.app.Activity;
import android.util.Log;

import androidx.fragment.app.Fragment;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class AppManager {
    private static final String TAG = "ActivityStackManager";

//    使用弱引用防止内存泄漏
    private static Stack<WeakReference<Activity>> activityStack;
    private static Stack<Fragment> fragmentStack;
    private static AppManager instance;

    private AppManager(){

    }
//singlon mode
    public static AppManager getAppManager(){
        if(instance == null){
            instance = new AppManager();
        }
        return instance;
    }
//    获取栈
    public static Stack<WeakReference<Activity>> getActivityStack(){
        return activityStack;
    }
    public static Stack<Fragment> getFragmentStack(){
        return fragmentStack;
    }

    public void addActivity(WeakReference<Activity> activity){
        if(activityStack == null){
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    public void removeActivity(WeakReference<Activity> activity){
        if(activity != null){
            activityStack.remove(activity);
        }
    }

    public boolean hasActivity() {
        if (activityStack != null) {
            return !activityStack.isEmpty();
        }
        return false;
    }

    public Activity getCurrentActivity(){
        Activity activity = activityStack.lastElement().get();
        return activity;
    }

    public void finishActivity(){
        try {
            WeakReference<Activity> activity = activityStack.lastElement();
            finishActivity(activity);
        }catch (Exception e){
            Log.d(TAG,e.getMessage());
        }
    }
//    结束指定的activity
    public void finishActivity(WeakReference<Activity> activity) {
        try {
            Iterator<WeakReference<Activity>> iterator = activityStack.iterator();
            while (iterator.hasNext()){
                WeakReference<Activity> stackActivity = iterator.next();
                if(stackActivity.get() == null){
                    iterator.remove();
                    continue;
                }
                if(stackActivity.get().getClass().getName().equals(activity.get().getClass().getName())){
                    iterator.remove();  // 数据结构中去除
                    stackActivity.get().finish();   //fininsh  obj
                    break;
                }
            }
        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }

    /**
     * 结束指定类名的activity
     */
    public void finishActivity(Class<?> cls){
        try {
            ListIterator<WeakReference<Activity>> listIterator = activityStack.listIterator();
            while (listIterator.hasNext()){
                Activity activity = listIterator.next().get();
                if(activity == null){
                    listIterator.remove();
                    continue;
                }
                if(activity.getClass() == cls){
                    listIterator.remove();  // 数据结构中去除
                    activity.finish();   //fininsh  obj
                    break;
                }
            }
        }catch (Exception e){
            Log.d(TAG,e.getMessage());
        }
    }

    public void finishAllActivity(){
        ListIterator<WeakReference<Activity>> listIterator = activityStack.listIterator();
        while (listIterator.hasNext()){
            Activity activity = listIterator.next().get();
            if(activity == null){
                activity.finish();
            }
            listIterator.remove();
        }
        activityStack.clear();
//        Process.killProcess(Process.myPid());
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    public Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (WeakReference<Activity> activity : activityStack) {
                if (activity.get().getClass().equals(cls)) {
                    return activity.get();
                }
            }
        return null;
    }



    /**
     * 添加Fragment到堆栈
     */
    public void addFragment(Fragment fragment) {
        if (fragmentStack == null) {
            fragmentStack = new Stack<Fragment>();
        }
        fragmentStack.add(fragment);
    }

    /**
     * 移除指定的Fragment
     */
    public void removeFragment(Fragment fragment) {
        if (fragment != null) {
            fragmentStack.remove(fragment);
        }
    }


    /**
     * 是否有Fragment
     */
    public boolean hasFragment() {
        if (fragmentStack != null) {
            return !fragmentStack.isEmpty();
        }
        return false;
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Fragment currentFragment() {
        if (fragmentStack != null) {
            Fragment fragment = fragmentStack.lastElement();
            return fragment;
        }
        return null;
    }
    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
            // 杀死该应用进程
//          android.os.Process.killProcess(android.os.Process.myPid());
//            调用 System.exit(n) 实际上等效于调用：
//            Runtime.getRuntime().exit(n)
//            finish()是Activity的类方法，仅仅针对Activity，当调用finish()时，只是将活动推向后台，并没有立即释放内存，活动的资源并没有被清理；当调用System.exit(0)时，退出当前Activity并释放资源（内存），但是该方法不可以结束整个App如有多个Activty或者有其他组件service等不会结束。
//            其实android的机制决定了用户无法完全退出应用，当你的application最长时间没有被用过的时候，android自身会决定将application关闭了。
            //System.exit(0);
        } catch (Exception e) {
            activityStack.clear();
            e.printStackTrace();
        }
    }

}
