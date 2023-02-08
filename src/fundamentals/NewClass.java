/*
 * To change this license header, choose License Headers stream Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template stream the editor.
 */
package fundamentals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jakata
 */
public class NewClass {

    int[] nums;

    public NewClass(int[] arr) {
        this.nums = Arrays.copyOf(arr, arr.length);
    }

    public void print() {
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void readFile(final File file, Charset charset) {
        InputStream stream = null;
        String content;
        try {
            stream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            int offset = 0;
            while (offset < bytes.length) {
                int result = stream.read(bytes, offset, bytes.length - offset);
                if (result == -1) {
                    break;
                }
                offset += result;
            }
            content = new String(bytes, charset);
            System.out.println(content);
        } catch (IOException ex) {
            throw new RuntimeException("I/O operation failed", ex);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (final IOException ex) {
                    /* do nothing */
                }
            }
        }
    }

    /**
     * Reads file from the file system.
     *
     * @param file Input file to be read
     * @throws IOException if an I/O error occurs.
     */
    public void readFile(final File file) throws IOException {
        runTask(() -> {
            try {
                Files.readAllBytes(file.toPath());
            } catch (final IOException ex) {
                throw new RuntimeException("Error reading file", ex);
            }
        });
    }

    public int sum(int... numbers) {
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return sum;
    }

    public void runTask(final Runnable runnable) {
        runnable.run();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4};
        NewClass nc = new NewClass(arr);
        nc.print();
        arr[0] = 88;
        nc.print();
        try {
            nc.readFile(new File("E:\\Jakata\\academia\\sql_notes.sql"));
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
