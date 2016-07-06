package org.springframework.shell;

import java.io.IOException;
import java.util.logging.Logger;

import org.junit.Assert;

import org.junit.Test;
import org.springframework.shell.core.JLineShellComponent;
import org.springframework.shell.support.logging.HandlerUtils;

public class SimpleShellCommandLineOptionsTest {

    @Test
    public void testPorcelain() throws IOException {
        try {
            String[] args = {"--porcelain"};
            Bootstrap bootstrap = new Bootstrap(args);
            JLineShellComponent shell = bootstrap.getJLineShellComponent();

            Assert.assertTrue("isPorcelain should be true", shell.getCommandLine().isPorcelain());
        } catch (RuntimeException t) {
            throw t;
        } finally {
            HandlerUtils.flushAllHandlers(Logger.getLogger(""));
        }

    }

    @Test
    public void testNoPorcelain() throws IOException {
        try {
            String[] args = {};
            Bootstrap bootstrap = new Bootstrap(args);
            JLineShellComponent shell = bootstrap.getJLineShellComponent();

            Assert.assertFalse("isPorcelain should be false", shell.getCommandLine().isPorcelain());
        } catch (RuntimeException t) {
            throw t;
        } finally {
            HandlerUtils.flushAllHandlers(Logger.getLogger(""));
        }

    }

}
