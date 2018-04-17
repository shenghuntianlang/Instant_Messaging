package instant_messaging.lightspeak_app;

import android.widget.TextView;

import com.lightspeak.common.app.Activity;

import butterknife.BindView;

public class MainActivity extends Activity {
    @BindView(R.id.textView)
    TextView textView;

    @Override
    public int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        textView.setText("The ButterKnife is injected successfully!!!");
    }
}
