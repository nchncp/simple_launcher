package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicha on 9/8/16.
 */
public class AppsListActivity extends Activity {

    /** Manager. */
    private PackageManager manager;
    /** Store list of apps. */
    private List<AppInfo> apps;
    private ListView list;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_apps_list);
        loadApps();
        loadListView();
        addClickListener();

    }

    private void addClickListener() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = manager.getLaunchIntentForPackage(apps.get(position).name.toString());
                AppsListActivity.this.startActivity(i);
            }
        });
    }

    private void loadListView() {
        list = (ListView) findViewById(R.id.apps_list);

        ArrayAdapter<AppInfo> adapter = new ArrayAdapter<AppInfo>(this, R.layout.list_item, apps) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                ViewHolderItem viewHolder = null;

                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false);
                    viewHolder = new ViewHolderItem();
                    viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
                    viewHolder.label = (TextView) convertView.findViewById(R.id.label);
                    viewHolder.name = (TextView) convertView.findViewById(R.id.name);

                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolderItem) convertView.getTag();
                }

                AppInfo appsInfo = apps.get(position);

                if (appsInfo != null) {
                    viewHolder.icon.setImageDrawable(appsInfo.icon);
                    viewHolder.label.setText(appsInfo.label);
                    viewHolder.name.setText(appsInfo.name);
                }

                return convertView;
            }

            final class ViewHolderItem {
                ImageView icon;
                TextView label;
                TextView name;
            }
        };

        list.setAdapter(adapter);
    }

    private void loadApps() {
        manager = getPackageManager();
        apps = new ArrayList<AppInfo>();

        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);

        //load apps
        List<ResolveInfo> avaliableActivities = manager.queryIntentActivities(i, 0);

        for (ResolveInfo ri : avaliableActivities) {
            AppInfo appInfo = new AppInfo();
            appInfo.label = ri.loadLabel(manager);
            appInfo.name = ri.activityInfo.packageName;
            appInfo.icon = ri.activityInfo.loadIcon(manager);
            apps.add(appInfo);

        }
    }
}
