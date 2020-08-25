package live.zj.apidemo.media;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

public class MetadataLoader extends AsyncTaskLoader<List<Metadata>> {
    public MetadataLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<Metadata> loadInBackground() {
        ArrayList<Metadata> metadataList = new ArrayList<>();

        return null;
    }
}
