package com.example.elderly.simplelauncher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

/**
 * Created by nicha on 9/27/16.
 */

public class GalleryPhoto extends Activity {
    private GalleryPhotoAdapter mAdapter;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_photo);

        String[] urls = initSampleData();
        mGridView = (GridView) findViewById(R.id.gridview);
        mAdapter = new GalleryPhotoAdapter(this, urls);
        mGridView.setAdapter(mAdapter);
    }

    private String[] initSampleData() {
        return new String[]{
                "https://d13yacurqjgara.cloudfront.net/users/3460/screenshots/1628158/animal-stickers_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/14521/screenshots/1628431/designers_wanted_2_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/57127/screenshots/1628433/kickstarterproject_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/26059/screenshots/1628196/enter_1x.gif",
                "https://d13yacurqjgara.cloudfront.net/users/32336/screenshots/1627983/dribbble3_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/254554/screenshots/1628567/20140703--satellit2_1x.gif",
                "https://d13yacurqjgara.cloudfront.net/users/144388/screenshots/1628118/table-creative-dribbble_1x.gif",
                "https://d13yacurqjgara.cloudfront.net/users/13307/screenshots/1628973/logotypes_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/45269/screenshots/1628472/workspace_1x.gif",
                "https://d13yacurqjgara.cloudfront.net/users/124059/screenshots/1627992/search-filter_1x.gif",
                "https://d13yacurqjgara.cloudfront.net/users/3375/screenshots/1628760/btt_cody_forever_1x.gif",
                "https://d13yacurqjgara.cloudfront.net/users/79978/screenshots/1628721/koltozzbe.hu_2_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/51395/screenshots/1628377/mercedes_minisite_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/465131/screenshots/1628903/rpg_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/267247/screenshots/1628670/prayer_app_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/303896/screenshots/1628068/sitepreview_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/9964/screenshots/1628170/crank-it-up_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/155551/screenshots/1628228/icons_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/38311/screenshots/1628047/dfst-mg4_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/146798/screenshots/1628405/bubbly_birdy_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/607501/screenshots/1628351/logo_mockup_display__07_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/147435/screenshots/1628399/sufweb_teaser.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/111948/screenshots/1628041/rocket-pop_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/157303/screenshots/1628313/12_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/24711/screenshots/1628676/trivantis-city_2x_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/604158/screenshots/1627943/final_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/25416/screenshots/1628248/drib_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/292484/screenshots/1628461/designers_guide_to_startup_weekend-1_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/5976/screenshots/1628234/space_watchers_eye_planet_logo_design_symbol_by_alex_tass_teaser.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/271951/screenshots/1628799/thumb_1x.jpg",
                "https://d13yacurqjgara.cloudfront.net/users/483231/screenshots/1628447/anicons1_1x.png",
                "https://d13yacurqjgara.cloudfront.net/users/16540/screenshots/1628044/engage.independence.dribbb_1x.jpg"
        };
    }
}