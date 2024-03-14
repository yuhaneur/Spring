<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>가상 강의실 - VR 교육</title>
        <style>
        .background-image {
            position: relative;
            z-index: 1; /* 이미지의 z-index 값 설정 */
        }
        .button {
            position: absolute;
            top: 100px; /* 버튼의 상대적인 위치 설정 */
            left: 100px; /* 버튼의 상대적인 위치 설정 */
            z-index: 2; /* 버튼의 z-index 값 설정 (이미지보다 큰 값으로 설정) */
        }
    </style>
    <script src="https://aframe.io/releases/1.2.0/aframe.min.js"></script>
</head>
<body>
    <a-scene>
        <!-- 전체 배경 이미지 -->
        <a-sky  src="./test.jpg" width="20"></a-sky>
        
       <!-- 가상 강의실 벽 -->
        <a-plane
            color="#FFFFFF" <!-- 벽의 색상, 이미지와 겹쳐 보이지 않도록 흰색으로 설정 -->
            width="10" height="5"
            position="0 2 -5"
            rotation="0 0 0"
        ></a-plane>
        
        <!-- 강사 -->
        <a-box
            color="#FFA500"
            width="0.5" height="1" depth="0.5"
            position="-1 1 -3"
        ></a-box>
        <a-text
            color="#000"
            position="-1 2 -3"
            value="강사"
            align="center"
            scale="2 2 2"
        ></a-text>
        
        <!-- 학생 -->
        <a-box
            color="#00FF00"
            width="0.5" height="1" depth="0.5"
            position="1 1 -3"
        ></a-box>
        <a-text
            color="#000"
            position="1 2 -3"
            value="학생"
            align="center"
            scale="2 2 2"
        ></a-text>

        <!-- 버튼 -->
        <a-entity
            geometry="primitive: box; width: 1; height: 0.2; depth: 0.2;"
            material="color: #336699;"
            position="0 1.5 -3" <!-- 버튼의 위치 -->
            rotation="0 0 0"
            z-index="1"
        ></a-entity>
        <a-text
            color="#FFFFFF"
            position="0 1.7 -3" <!-- 텍스트의 위치 -->
            value="버튼"
            align="center"
            scale="2 2 2"
        ></a-text>
    </a-scene>
</body>
</html>