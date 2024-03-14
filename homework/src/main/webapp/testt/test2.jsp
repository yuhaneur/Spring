<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Video Conference</title>
</head>
<body>
    <h1>Video Conference</h1>

    <div id="videos">
        <video id="localVideo" autoplay muted style="width: 300px; height: 200px;"></video>
        <video id="remoteVideo" autoplay style="width: 300px; height: 200px;"></video>
    </div>

    <script>
        let localStream;
        let remoteStream;
        let pc1;
        let pc2;

        async function startVideo() {
            try {
                localStream = await navigator.mediaDevices.getUserMedia({ video: true, audio: true });
                document.getElementById('localVideo').srcObject = localStream;
            } catch (error) {
                console.error('Error accessing media devices.', error);
            }
        }

        async function startCall() {
            pc1 = new RTCPeerConnection();
            pc2 = new RTCPeerConnection();

            // Add local stream to pc1
            localStream.getTracks().forEach(track => pc1.addTrack(track, localStream));

            pc1.onicecandidate = event => {
                if (event.candidate) {
                    pc2.addIceCandidate(new RTCIceCandidate(event.candidate));
                }
            };

            pc2.onicecandidate = event => {
                if (event.candidate) {
                    pc1.addIceCandidate(new RTCIceCandidate(event.candidate));
                }
            };

            pc2.ontrack = event => {
                remoteStream = event.streams[0];
                document.getElementById('remoteVideo').srcObject = remoteStream;
            };

            const offer = await pc1.createOffer();
            await pc1.setLocalDescription(offer);
            await pc2.setRemoteDescription(offer);

            const answer = await pc2.createAnswer();
            await pc2.setLocalDescription(answer);
            await pc1.setRemoteDescription(answer);
        }

        startVideo();
    </script>

    <button onclick="startCall()">Start Call</button>
</body>
</html>