/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.packageinstaller.permission.model;

import android.app.AppOpsManager;

import androidx.annotation.NonNull;

/**
 * A single instance of an app accessing a permission.
 */
public final class AppPermissionUsage {
    private final AppOpsManager.PackageOps mPkgOp;
    private final AppOpsManager.OpEntry mOp;
    private final CharSequence mPermissionGroupLabel;

    AppPermissionUsage(@NonNull AppOpsManager.PackageOps pkgOp, @NonNull AppOpsManager.OpEntry op,
            @NonNull CharSequence permissionGroupLabel) {
        mPkgOp = pkgOp;
        mOp = op;
        mPermissionGroupLabel = permissionGroupLabel;
    }

    public @NonNull String getPackageName() {
        return mPkgOp.getPackageName();
    }

    public int getUid() {
        return mPkgOp.getUid();
    }

    public long getTime() {
        return mOp.getLastAccessTime();
    }

    public @NonNull CharSequence getPermissionGroupLabel() {
        return mPermissionGroupLabel;
    }
}