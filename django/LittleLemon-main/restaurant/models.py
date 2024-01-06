from django.db import models
from django.core.validators import MinValueValidator, MaxValueValidator
# Create your models here.

class Menu(models.Model):
    title = models.CharField(max_length = 255)
    price = models.DecimalField(max_digits=10,decimal_places=2)
    inventory = models.IntegerField(validators=[MinValueValidator(0), MaxValueValidator(99999)])
    # def __str__(self): 
    #     return self.title
    #for test_model.py
    def __str__(self):
        return f'{self.title} : {str(self.price)}'

    
class Booking(models.Model):
    name = models.CharField(max_length=255)
    no_of_guests = models.IntegerField(validators=[MinValueValidator(0), MaxValueValidator(999999)])
    bookingdate = models.DateTimeField()
    
    
    def __str__(self): 
        return self.name