import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;

import java.net.URI;
import java.nio.charset.StandardCharsets;

public class S3ServiceImpl {

    private final S3Client s3Client;
    private final String bucketName = "my-local-bucket";

    public S3ServiceImpl() {
        this.s3Client = S3Client.builder()
                .region(Region.US_EAST_1)
                .endpointOverride(URI.create("http://localhost:4566")) // LocalStack endpoint
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("test", "test")))
                .build();
    }

    public void uploadJson(String jsonData, String fileName) {
        byte[] fileContent = jsonData.getBytes(StandardCharsets.UTF_8);

        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType("application/json")
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(fileContent));

        System.out.println("✅ JSON uploaded successfully: " + fileName);
    }

    public static void main(String[] args) {
        S3Service s3Service = new S3Service();
        s3Service.uploadJson("{\"message\": \"Hello LocalStack!\"}", "test.json");
    }
}
