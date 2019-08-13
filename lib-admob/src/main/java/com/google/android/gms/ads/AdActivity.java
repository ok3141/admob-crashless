package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzamu;
import com.google.android.gms.internal.ads.zzawo;
import com.google.android.gms.internal.ads.zzuo;

public final class AdActivity extends Activity {
    private zzamu zzaaw;

    public static Reporter reporter;

    public interface Reporter {
        void report(Throwable exception, String event);
    }

    private static void report(Throwable exception, String event) {
        Reporter r = reporter;
        if (r != null) {
            r.report(exception, event);
        }
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        try {
            super.setRequestedOrientation(requestedOrientation);
        } catch (RuntimeException ex) {
            report(ex, "adactivity_set_req_ornt");
        }
    }

    @Override
    public void finish() {
        super.finish();

        overridePendingTransition(0, 0);
    }

    protected void onCreate(Bundle var1) {
        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE);

            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );

            super.onCreate(var1);
            this.zzaaw = zzuo.zzog().zzb(this);
            if (this.zzaaw == null) {
                zzawo.zze("#007 Could not call remote method.", null);
                this.finish();
            } else {
                try {
                    this.zzaaw.onCreate(var1);
                } catch (RemoteException var3) {
                    zzawo.zze("#007 Could not call remote method.", var3);
                    this.finish();
                }
            }
        } catch (RuntimeException ex) {
            report(ex, "adactivity_on_create");

            finish();
        }
    }

    protected final void onRestart() {
        super.onRestart();

        try {
            if (this.zzaaw != null) {
                this.zzaaw.onRestart();
            }

        } catch (RemoteException var2) {
            zzawo.zze("#007 Could not call remote method.", var2);
            this.finish();
        }
    }

    protected final void onStart() {
        super.onStart();

        try {
            if (this.zzaaw != null) {
                this.zzaaw.onStart();
            }

        } catch (RemoteException var2) {
            zzawo.zze("#007 Could not call remote method.", var2);
            this.finish();
        }
    }

    protected final void onResume() {
        super.onResume();

        try {
            if (this.zzaaw != null) {
                this.zzaaw.onResume();
            }

        } catch (RemoteException var2) {
            zzawo.zze("#007 Could not call remote method.", var2);
            this.finish();
        }
    }

    protected final void onPause() {
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onPause();
            }
        } catch (RemoteException var2) {
            zzawo.zze("#007 Could not call remote method.", var2);
            this.finish();
        }

        super.onPause();
    }

    protected final void onSaveInstanceState(@NonNull Bundle var1) {
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onSaveInstanceState(var1);
            }
        } catch (RemoteException var3) {
            zzawo.zze("#007 Could not call remote method.", var3);
            this.finish();
        }

        super.onSaveInstanceState(var1);
    }

    protected final void onStop() {
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onStop();
            }
        } catch (RemoteException var2) {
            zzawo.zze("#007 Could not call remote method.", var2);
            this.finish();
        }

        super.onStop();
    }

    protected final void onDestroy() {
        try {
            if (this.zzaaw != null) {
                this.zzaaw.onDestroy();
            }
        } catch (RemoteException var2) {
            zzawo.zze("#007 Could not call remote method.", var2);
        }

        super.onDestroy();
    }

    private void zzcz() {
        if (this.zzaaw != null) {
            try {
                this.zzaaw.zzcz();
            } catch (RemoteException var2) {
                zzawo.zze("#007 Could not call remote method.", var2);
            }
        }
    }

    public final void setContentView(int var1) {
        super.setContentView(var1);
        this.zzcz();
    }

    public final void setContentView(View var1) {
        super.setContentView(var1);
        this.zzcz();
    }

    public final void setContentView(View var1, LayoutParams var2) {
        super.setContentView(var1, var2);
        this.zzcz();
    }

    public final void onBackPressed() {
        boolean var1 = true;

        try {
            if (this.zzaaw != null) {
                var1 = this.zzaaw.zzsl();
            }
        } catch (RemoteException var3) {
            zzawo.zze("#007 Could not call remote method.", var3);
        }

        if (var1) {
            super.onBackPressed();
        }

    }

    protected final void onActivityResult(int var1, int var2, Intent var3) {
        try {
            this.zzaaw.onActivityResult(var1, var2, var3);
        } catch (Exception var5) {
            zzawo.zze("#007 Could not call remote method.", var5);
        }

        super.onActivityResult(var1, var2, var3);
    }

    public final void onConfigurationChanged(@NonNull Configuration var1) {
        super.onConfigurationChanged(var1);

        try {
            this.zzaaw.zzag(ObjectWrapper.wrap(var1));
        } catch (RemoteException var3) {
            zzawo.zze("#007 Could not call remote method.", var3);
        }
    }
}
