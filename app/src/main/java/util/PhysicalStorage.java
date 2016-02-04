package util;

import android.os.Environment;

import java.io.File;

public class PhysicalStorage
{
	public static String getExternalStorageRootPath()
	{
		String externalStorageRootPath = null;

		if (isExternalStorageMounted())
		{
			File externalStorageRoot = Environment.getExternalStorageDirectory();
			externalStorageRootPath = externalStorageRoot.getPath();
		}

		return externalStorageRootPath;
	}

	public static boolean isExternalStorageMounted()
	{
		boolean isExternalStorageMounted = false;

		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state))
		{
			isExternalStorageMounted = true;
		}

		return isExternalStorageMounted;
	}

}
