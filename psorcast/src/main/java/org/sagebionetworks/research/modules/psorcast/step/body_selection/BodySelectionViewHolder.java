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
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.sagebionetworks.research.mobile_ui.widget.ActionButton;
import org.sagebionetworks.research.modules.psorcast.R;

public class BodySelectionViewHolder extends RecyclerView.ViewHolder {
    private final ActionButton button;
    private final ShowBodySelectionStepFragment fragment;
    private final RecyclerView parent;
    private String choice;

    public BodySelectionViewHolder(final ShowBodySelectionStepFragment fragment, final RecyclerView parent,
                                   final ActionButton button) {
        super(button);
        this.button = button;
        this.parent = parent;
        this.fragment = fragment;
        this.button.setOnClickListener(view -> {
            int inactiveColor = parent.getContext().getResources().getColor(R.color.transparent);
            int activeColor = view.getContext().getResources().getColor(R.color.appLightGray);
            BodySelectionAdapter<?> adapter = (BodySelectionAdapter<?>)parent.getAdapter();

            // Choice "none" logic:
            // If user selected "none", clear all selections.
            // Otherwise, clear "none" selection.
            int children = parent.getChildCount();
            if (this.choice.equals("none")) {
                for (int i = 0; i < children; i++) {
                    View child = parent.getChildAt(i);
                    child.setBackgroundColor(inactiveColor);
                }
            } else {
                View child = parent.getChildAt(children - 1);
                child.setBackgroundColor(inactiveColor);
            }

            if (adapter.updateSelectedChoices(this.choice)) {
                button.setBackgroundColor(activeColor);
            } else {
                button.setBackgroundColor(inactiveColor);
            }

            // Write the selected body regions to the task result
            fragment.writeBodySelectionResult(adapter.getSelectedChoices());
        });
    }

    public ActionButton getButton() {
        return this.button;
    }

    public void setChoice(@NonNull String choice) {
        this.choice = choice;
    }
}