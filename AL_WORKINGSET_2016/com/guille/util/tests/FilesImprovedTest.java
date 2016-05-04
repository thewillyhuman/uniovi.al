package com.guille.util.tests;

import java.io.File;
import java.io.IOException;
import org.junit.Test;
import com.guille.util.FilesImproved;

public class FilesImprovedTest {

    @Test
    public void test() throws IOException {
	FilesImproved.splitFile("/Users/guille/Desktop/tests/","video","mp4");
	FilesImproved.mergeFiles(new File("/Users/guille/Desktop/tests/video.mp4.001"), new File("/Users/guille/Desktop/tests/videoRecomposed.mp4"));
    }

}
