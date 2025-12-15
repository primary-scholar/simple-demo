package com.mimu.simple.java.stream;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;

/**
 * @author luyahui
 * @date 2023/9/16
 * @description
 */
public class FileHolder {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileHolder.class);
    private static final Path MAC_OS_LOCAL = Paths.get("/Users/didi/Documents/");
    private static final Path LINUX_OS_LOCAL = Paths.get("/home/xiaoju/file/");
    private final String OSS_FILE_URL = "/didi/merchant/firmware/", tmp = "tmp", bucketName = "bike-ota", mac = "mac os x";
    private File localFile;
    private Long fileSize;
    private String fileMd5;

    public FileHolder(String ossUrl) {
        initLocalFile(String.valueOf(System.currentTimeMillis()));
        try {
            String decode = URLDecoder.decode(ossUrl, Charset.defaultCharset().name());
            String ossFilePath = decode.substring(ossUrl.indexOf(OSS_FILE_URL) + NumberUtils.INTEGER_ONE);
            this.fileSize = calculateFileSize();
            this.fileMd5 = calculateMd5();
            Files.delete(localFile.toPath());
        } catch (IOException e) {
            LOGGER.error("FileHolder error..", e);
        }
    }

    /**
     * 创建文件
     *
     * @param fileName 文件名称
     */
    private File initLocalFile(String fileName) {

        OperatingSystemMXBean systemMXBean = ManagementFactory.getOperatingSystemMXBean();
        String osName = systemMXBean.getName();
        Path local;
        if (osName.toLowerCase().contains(mac)) {
            local = MAC_OS_LOCAL;
        } else {
            local = LINUX_OS_LOCAL;
        }
        String tmp = "tmp";
        Path tmpDir = local.resolve(tmp);
        if (!tmpDir.toFile().exists()) {
            tmpDir.toFile().mkdirs();
        }
        localFile = tmpDir.resolve(fileName).toFile();
        if (!localFile.exists()) {
            try {
                Files.createFile(localFile.toPath());
            } catch (IOException e) {
                LOGGER.error("ExcelFileHolder create file error path={}", localFile.getAbsolutePath(), e);
            }
        }
        return localFile;
    }

    private String calculateMd5() {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            DigestInputStream digestInputStream = new DigestInputStream(new BufferedInputStream(new FileInputStream(localFile)), md5);
            byte[] buffer = new byte[4096];
            while (digestInputStream.read(buffer) != -1) ;
            byte[] digest = md5.digest();
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Long calculateFileSize() {
        return Objects.nonNull(localFile) ? localFile.length() : 0L;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public String getFileMd5() {
        return fileMd5;
    }
}
