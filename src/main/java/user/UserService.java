package user;

import com.fun.grpcExample.User;
import com.fun.grpcExample.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside login");
        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if(username.equals(password))
        {
            //return success
            response.setResponseCode(0).setResponseMessage("SUCCESS");
        }
        else
        {
            //return failure
            response.setResponseCode(100).setResponseMessage("INVALID PASSWORD");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

    }
}
