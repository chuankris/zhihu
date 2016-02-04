package util;

import android.content.Context;
import android.widget.Toast;

import com.zhihu.chuankris.myapplication.preferrence.GlobalContext;


/**
 * User: qiuxuechuan
 * Date: 15.6.11
 * function:baseToastUtils
 */
public class ToastUtils
{

	private static Toast toast = null;

	public static void showToast(final String msg)
	{
		showToast(GlobalContext.getInstance().getApplicationContext(), msg, Toast.LENGTH_SHORT);
	}

	public static void showToast(final int msg)
	{
		showToast(GlobalContext.getInstance().getApplicationContext(), msg, Toast.LENGTH_SHORT);
	}

	private static synchronized void showToast(final Context act, final String msg, final int len)
	{

		if (toast != null)
		{
			toast.setText(msg);
			toast.show();
		}
		else
		{
			toast = Toast.makeText(act, msg, len);
			toast.show();
		}
	}

	private static synchronized void showToast(final Context act, final int msg, final int len)
	{

		if (toast != null)
		{
			toast.setText(msg);
			toast.show();
		}
		else
		{
			toast = Toast.makeText(act, msg, len);
			toast.show();
		}
	}

}
