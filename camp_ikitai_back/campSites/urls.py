from campSites import views
from django.urls import path


urlpatterns = [
    path('', views.hello_world, name='hello'),
]
