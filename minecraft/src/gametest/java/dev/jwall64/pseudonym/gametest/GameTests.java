package dev.jwall64.pseudonym.gametest;

import java.lang.reflect.Method;

import org.jspecify.annotations.NonNull;
import dev.jwall64.mdcfg.ConfigSection;
import dev.jwall64.mdcfg.mc.api.ServerSQLManager;

import net.fabricmc.fabric.api.gametest.v1.CustomTestMethodInvoker;
import net.fabricmc.fabric.api.gametest.v1.GameTest;

import net.minecraft.gametest.framework.GameTestHelper;

public class GameTests implements CustomTestMethodInvoker {

    @Override
    public void invokeTestMethod(GameTestHelper helper, @NonNull Method method) throws ReflectiveOperationException {
        method.invoke(this, helper);
    }


    @GameTest
    public void emptyTest(GameTestHelper helper) {

        helper.succeed();
    }
}
