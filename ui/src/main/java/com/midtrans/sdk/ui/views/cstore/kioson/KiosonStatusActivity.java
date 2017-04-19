package com.midtrans.sdk.ui.views.cstore.kioson;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.midtrans.sdk.ui.R;
import com.midtrans.sdk.ui.abtracts.BaseStatusActivity;
import com.midtrans.sdk.ui.constants.Theme;
import com.midtrans.sdk.ui.widgets.FancyButton;

/**
 * Created by rakawm on 4/6/17.
 */

public class KiosonStatusActivity extends BaseStatusActivity {
    public static final String EXTRA_PAYMENT_CODE = "kioson.code";
    public static final String EXTRA_VALIDITY = "kioson.validity";

    private static final String LABEL_PAYMENT_CODE = "Payment Code";

    private TextView paymentCodeText;
    private FancyButton copyPaymentCodeButton;
    private TextView validityText;
    private FancyButton seeInstructionButton;

    private String paymentCode;
    private String validity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kioson_status);
        initExtras();
        initViews();
        initThemes();
        initValues();
        initCopyPaymentCodeButton();
        initKiosonInstruction();
    }

    private void initExtras() {
        paymentCode = getIntent().getStringExtra(EXTRA_PAYMENT_CODE);
        validity = getIntent().getStringExtra(EXTRA_VALIDITY);
    }

    private void initViews() {
        paymentCodeText = (TextView) findViewById(R.id.indomaret_payment_code);
        copyPaymentCodeButton = (FancyButton) findViewById(R.id.copy_payment_code_button);
        validityText = (TextView) findViewById(R.id.text_validity);
        seeInstructionButton = (FancyButton) findViewById(R.id.btn_see_instruction);
    }

    private void initThemes() {
        setBackgroundColor(paymentCodeText, Theme.SECONDARY_COLOR);
        paymentCodeText.getBackground().setAlpha(50);

        setBorderColor(copyPaymentCodeButton);
        setTextColor(copyPaymentCodeButton);

        setBorderColor(seeInstructionButton);
        setTextColor(seeInstructionButton);
    }

    private void initValues() {
        paymentCodeText.setText(paymentCode);
        validityText.setText(validity);
    }

    @Override
    public void onBackPressed() {
        finishPayment();
    }

    private void initCopyPaymentCodeButton() {
        copyPaymentCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copyPaymentCode();
            }
        });
    }

    /**
     * Copy payment code into clipboard.
     */
    private void copyPaymentCode() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(LABEL_PAYMENT_CODE, paymentCodeText.getText().toString());
        clipboard.setPrimaryClip(clip);
        // Show toast
        Toast.makeText(this, R.string.copied_to_clipboard, Toast.LENGTH_SHORT).show();
    }

    private void initKiosonInstruction() {
        seeInstructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startKiosonInstruction();
            }
        });
    }

    private void startKiosonInstruction() {
        Intent intent = new Intent(this, KiosonInstructionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void finishPayment() {
        setResult(RESULT_OK);
        finish();
    }
}