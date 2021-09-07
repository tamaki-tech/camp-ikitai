from camp_sites.models import CampSite
from rest_framework import serializers


class CampSiteSerializer(serializers.ModelSerializer):
    class Meta:
        model = CampSite
