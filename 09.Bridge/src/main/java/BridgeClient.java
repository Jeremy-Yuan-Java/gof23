public class BridgeClient {
    public static void main(String[] args) {
        OperatingSystemVersion os = new Windows(new AVIFile());
       os.play("战狼三");
    }
}

interface VideoFile {
    void decode(String fileName);
}

class AVIFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("AVI视频文件" + fileName);
    }
}

class REVBBFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("rmbv文件" + fileName);
    }
}

abstract class OperatingSystemVersion {
    protected VideoFile videoFile;

    public OperatingSystemVersion(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    public abstract void play(String fileName);
}

class Windows extends OperatingSystemVersion {

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}

class Mac extends OperatingSystemVersion {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}