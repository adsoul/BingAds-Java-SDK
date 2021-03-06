package com.microsoft.bingads.v13.internal.bulk;

import java.io.File;
import java.io.IOException;

import com.microsoft.bingads.v13.bulk.BulkFileReader;
import com.microsoft.bingads.v13.bulk.DownloadFileType;
import com.microsoft.bingads.v13.bulk.ResultFileType;

public interface BulkFileReaderFactory {

	BulkFileReader createBulkFileReader(File localFile, ResultFileType fileType, DownloadFileType downloadFileType, boolean deleteFileOnClose)
			throws IOException;

}
