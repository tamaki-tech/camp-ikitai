from django.shortcuts import render
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework.decorators import api_view

# Create your views here.


class HelloWorld(APIView):

    def get(self, request, format=None):
        return Response({"message": "Hello World!!"},
                        status=status.HTTP_200_OK)


@api_view(['GET'])
def hello_world(request):

    if request.method == 'GET':
        return Response({"message": "Hello function base APIView GET!!"},
                        status=status.HTTP_200_OK)

