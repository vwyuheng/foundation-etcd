package net.basiccloud.tecd.distributed.lock;


import net.basiccloud.distributed.lock.ExclusiveLock;

import java.util.concurrent.TimeUnit;

public class ExclusiveLockImpl implements ExclusiveLock {

    @Override
    public void setLockName(String s) {

    }

    @Override
    public boolean lock() {
        return false;
    }

    @Override
    public void setTimeOut(long l, TimeUnit timeUnit) {

    }

    @Override
    public void unLock() {

    }
}
