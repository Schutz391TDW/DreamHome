//Andrew Schutzbach 001
class House {
    private final double TAX = 0.05;
    public int bedrooms;
    public int type;
    public double bathrooms;
    public double cost;
    String stringType;

    //sets Bedrooms
    public void setBedrooms(int userBedrooms) {
        bedrooms = userBedrooms + bedrooms;
    }

    //gets Bedrooms
    public int getBedrooms() {
        return bedrooms;
    }

    //sets Bathrooms
    public void setBathrooms(double userBathrooms) {
        bathrooms = userBathrooms + bathrooms;
    }

    //gets Bathrooms
    public double getBathrooms() {
        return bathrooms;
    }

    //sets Cost
    public void setCost(double cost) {
        this.cost = cost;
    }

    //gets Cost
    public double getCost(int userBedrooms, double userBathrooms) {
        cost = cost + (800 * userBedrooms) + (500 * userBathrooms) + TAX;
        return cost;
    }

    //sets Type
    public void setType(int userType) {
        type = userType;
        switch (type) {
            case 1:
                stringType = "Traditional";
                break;
            case 2:
                stringType = "Modern";
                break;
            case 3:
                stringType = "European";
                break;
            case 4:
                stringType = "Southwest";
                break;
            case 5:
                stringType = "Mountain";
                break;
            case 6:
                stringType = "Victorian";
                break;
            case 7:
                stringType = "Country";
        }
    }

    //gets type
    public String getType() {
        return stringType;
    }

}

//For Traditional House
class Traditional extends House {

    public Traditional() {
        bedrooms = 3;
        bathrooms = 2;
        cost = 3300;
    }
}

//For Modern House
class Modern extends House {

    public  Modern() {
        bedrooms = 2;
        bathrooms = 1.5;
        cost = 4200;
    }
}

//For European House
class European extends House {

    public European() {
        bedrooms = 2;
        bathrooms = 2;
        cost = 4700;
    }
}

//For Southwest House
class Southwest extends House {

    public Southwest() {
        bedrooms = 3;
        bathrooms = 2;
        cost = 3600;
    }
}

//For Mountain House
class Mountain extends House {

    public Mountain() {
        bedrooms = 3;
        bathrooms = 2;
        cost = 3500;
    }
}

//For Victorian House
class Victorian extends House {

    public Victorian() {
        bedrooms = 3;
        bathrooms = 2.5;
        cost = 3200;
    }
}

//For Country House
class Country extends House {

    public Country() {
        bedrooms = 3;
        bathrooms = 3;
        cost = 3000;
    }
}
