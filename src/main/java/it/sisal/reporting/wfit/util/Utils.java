/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.sisal.reporting.wfit.util.Utils
 */
package it.sisal.reporting.wfit.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Objects;

public class Utils {
    private Utils() {
    }

    public static String getFileContentFromResource(String resourceFilename) throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        StringBuilder out = new StringBuilder();
        try (InputStream inputStream = classloader.getResourceAsStream(resourceFilename);){
            int charsRead;
            int bufferSize = 1024;
            char[] buffer = new char[1024];
            InputStreamReader in = new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8);
            while ((charsRead = ((Reader)in).read(buffer, 0, buffer.length)) > 0) {
                out.append(buffer, 0, charsRead);
            }
        }
        return out.toString();
    }

    public static String setMDC(String stepName) {
        return stepName.concat("-").concat(Long.toString(Instant.now().toEpochMilli()));
    }

    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }
}

