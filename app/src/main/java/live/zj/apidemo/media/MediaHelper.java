package live.zj.apidemo.media;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.nio.ByteBuffer;

import wseemann.media.FFmpegMediaMetadataRetriever;

public class MediaHelper {

    public static void extractPicturesFromVideo(Context context, Uri videoUri, Surface surface) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(context, videoUri, null);
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            String mimeType = trackFormat.getString(MediaFormat.KEY_MIME);
            if (mimeType != null && mimeType.startsWith("video/")) {
                MediaCodec decoder = MediaCodec.createDecoderByType(mimeType);
                decoder.configure(trackFormat, surface, null, 0);
                decoder.start();
                extract(mediaExtractor, i, decoder, surface);
            }
        }
    }

    //
    private static void extract(MediaExtractor mediaExtractor, int trackIndex, MediaCodec decoder, Surface surface) {

    }

    public void retrieverImagesFromVideo(Context context, Uri videoUri) {
        FFmpegMediaMetadataRetriever retriever = new FFmpegMediaMetadataRetriever();

    }

    private static MediaCodecInfo selectCodec(String mimeType) {
        MediaCodecList mediaCodecList = new MediaCodecList(MediaCodecList.REGULAR_CODECS);
        MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
        for (MediaCodecInfo codecInfo : codecInfos) {
            if (!codecInfo.isEncoder()) {
                continue;
            }

            String[] types = codecInfo.getSupportedTypes();
            for (String type : types) {
                if (type.equalsIgnoreCase(mimeType)) {
                    return codecInfo;
                }
            }
        }
        return null;
    }

    public void test(MediaFormat mediaFormat, Surface surface) throws IOException {
        MediaCodecList mediaCodecList = new MediaCodecList(MediaCodecList.REGULAR_CODECS);
        String decoderName = mediaCodecList.findDecoderForFormat(mediaFormat);
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.LOLLIPOP) {
            mediaFormat.setString(MediaFormat.KEY_FRAME_RATE, null);
        }
        MediaCodec decoder = MediaCodec.createByCodecName(decoderName);
        decoder.setCallback(new MediaCodec.Callback() {
            @Override
            public void onInputBufferAvailable(@NonNull MediaCodec codec, int index) {
                ByteBuffer inputBuffer = codec.getInputBuffer(index);
            }

            @Override
            public void onOutputBufferAvailable(@NonNull MediaCodec codec, int index, @NonNull MediaCodec.BufferInfo info) {
                ByteBuffer outputBuffer = codec.getOutputBuffer(index);
            }

            @Override
            public void onError(@NonNull MediaCodec codec, @NonNull MediaCodec.CodecException e) {

            }

            @Override
            public void onOutputFormatChanged(@NonNull MediaCodec codec, @NonNull MediaFormat format) {
                codec.configure(format, surface, null, 0);
            }
        });
    }
}
