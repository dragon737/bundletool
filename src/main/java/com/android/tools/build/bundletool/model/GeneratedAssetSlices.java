/*
 * Copyright (C) 2019 The Android Open Source Project
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
 * limitations under the License
 */

package com.android.tools.build.bundletool.model;

import static com.google.common.collect.ImmutableList.toImmutableList;

import com.android.tools.build.bundletool.model.ModuleSplit.SplitType;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;

/** Represents a collection of generated Asset Slices. */
@Immutable
@AutoValue
@AutoValue.CopyAnnotations
public abstract class GeneratedAssetSlices {

  public abstract ImmutableList<ModuleSplit> getAssetSlices();

  public int size() {
    return getAssetSlices().size();
  }

  /** Creates a GeneratedAssetSlices instance from a list of module splits. */
  public static GeneratedAssetSlices fromModuleSplits(ImmutableList<ModuleSplit> moduleSplits) {
    ImmutableList<ModuleSplit> assetSlices =
        moduleSplits.stream()
            .filter(split -> split.getSplitType().equals(SplitType.ASSET_SLICE))
            .collect(toImmutableList());
    return new AutoValue_GeneratedAssetSlices(assetSlices);
  }
}
