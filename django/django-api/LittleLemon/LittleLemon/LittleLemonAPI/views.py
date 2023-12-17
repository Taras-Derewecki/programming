from django.views.generic import ListView, DetailView
from .models import MenuItem

class MenuItemListView(ListView):
    model = MenuItem
    template_name = 'menuitem_list.html'
    context_object_name = 'menu_items'

class MenuItemDetailView(DetailView):
    model = MenuItem
    template_name = 'menuitem_detail.html'
    context_object_name = 'menu_item'
