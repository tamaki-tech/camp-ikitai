from enum import unique
from django.db import models


class SiteType(models.Model):
    name = models.CharField(max_length=30)

    class Meta:
        db_table = "site_type"


class User(models.Model):
    name = models.CharField(max_length=30)
    mail_address = models.CharField(max_length=100)

    class Meta:
        db_table = "user"


class CampSite(models.Model):
    site_type = models.ForeignKey(SiteType, on_delete=models.PROTECT)
    name = models.CharField(max_length=30)
    addition = models.TextField(null=True, blank=True, max_length=300)
    access = models.CharField(max_length=30)
    phone_number = models.CharField(max_length=30)
    url = models.CharField(null=True, blank=True, max_length=10)
    price = models.IntegerField()
    image_path = models.ImageField(upload_to="images/")

    class Meta:
        db_table = "camp_site"


class Address(models.Model):
    camp_site = models.OneToOneField(
        CampSite, on_delete=models.PROTECT, primary_key=True)
    zip_code = models.CharField(blank=True, null=True, max_length=10)
    pref_name = models.CharField(blank=True, null=True, max_length=30)
    city_name = models.CharField(blank=True, null=True, max_length=30)
    other_address = models.CharField(blank=True, null=True, max_length=30)

    class Meta:
        db_table = "address"


class Coordinate(models.Model):
    camp_site = models.OneToOneField(
        CampSite, on_delete=models.PROTECT, primary_key=True)
    let = models.FloatField()
    lon = models.FloatField()

    class Meta:
        db_table = "coordinate"


class Facility(models.Model):
    camp_site = models.ForeignKey(CampSite, on_delete=models.PROTECT)
    name = models.CharField(blank=True, null=True, max_length=30)
    is_exist = models.BooleanField(default=False)

    class Meta:
        db_table = "facility"


class Ikitai(models.Model):
    user = models.ForeignKey(User, on_delete=models.PROTECT)
    camp_site = models.ForeignKey(CampSite, on_delete=models.PROTECT)

    class Meta:
        db_table = "ikitai"
        constraints = [
            models.UniqueConstraint(
                fields=["user", "camp_site"], name="unique_ikitai")
        ]


class Review(models.Model):
    camp_site = models.ForeignKey(CampSite, on_delete=models.PROTECT)
    user = models.ForeignKey(User, on_delete=models.PROTECT)
    point = models.IntegerField(default=0)
    Comment = models.TextField()

    class Meta:
        db_table = "review"
