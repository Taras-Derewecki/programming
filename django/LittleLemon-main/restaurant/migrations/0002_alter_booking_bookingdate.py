# Generated by Django 5.0 on 2023-12-20 01:04

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('restaurant', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='booking',
            name='bookingdate',
            field=models.DateField(auto_now_add=True),
        ),
    ]
