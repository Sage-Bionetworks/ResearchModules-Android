/*
 * BSD 3-Clause License
 *
 * Copyright 2019  Sage Bionetworks. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1.  Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2.  Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3.  Neither the name of the copyright holder(s) nor the names of any contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission. No license is granted to the trademarks of
 * the copyright holders even if such marks are included in this software.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sagebionetworks.research.modules.psorcast.step.body_selection;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import org.sagebionetworks.research.domain.async.AsyncActionConfiguration;
import org.sagebionetworks.research.domain.form.interfaces.InputField;
import org.sagebionetworks.research.domain.step.implementations.FormUIStepBase;
import org.sagebionetworks.research.domain.step.ui.action.Action;
import org.sagebionetworks.research.domain.step.ui.theme.ColorTheme;
import org.sagebionetworks.research.domain.step.ui.theme.ImageTheme;

import java.util.Map;
import java.util.Set;

public class BodySelectionStep extends FormUIStepBase {

    public static final String TYPE_KEY = "bodySelection";

    public BodySelectionStep(@NonNull final String identifier,
            @NonNull final Set<AsyncActionConfiguration> asyncActions,
            @Nullable final Map<String, Action> actions,
            @Nullable final Set<String> hiddenActions,
            @Nullable final String title, @Nullable final String text,
            @Nullable final String detail,
            @Nullable final String footnote,
            @Nullable final ColorTheme colorTheme,
            @Nullable final ImageTheme imageTheme,
            @NonNull final ImmutableList<InputField> inputFields) {
        super(identifier, asyncActions, actions, hiddenActions, title, text, detail, footnote, colorTheme, imageTheme,
                inputFields);
    }

    @Override
    @NonNull
    public BodySelectionStep copyWithIdentifier(@NonNull String identifier) {
        return new BodySelectionStep(identifier, this.getAsyncActions(), this.getActions(), this.getHiddenActions(), this.getTitle(),
                this.getText(), this.getDetail(), this.getFootnote(), this.getColorTheme(), this.getImageTheme(),
                this.getInputFields());
    }

    @Override
    public String getType() { return TYPE_KEY; }
}