public non-sealed class USClock extends Clock{

    private String periodIndicator;

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setAfterMidday(){
        this.periodIndicator = "PM";
    }

    public void setBeforMidday(){
        this.periodIndicator = "AM";
    }

    public void setHour(int hour){
        setBeforMidday();
        if ((hour >= 12) && (hour <= 23)) {
            setAfterMidday();
            this.hour = hour = 12;
            return;
        } else if (hour >= 24){

            this.hour = hour = 0;
        }else {
            this.hour = hour;
        }
    }

    @Override
    Clock convert(Clock clock) {
        switch (clock){
            case USClock usClock ->{
                this.hour = usClock.getHour();
                this.periodIndicator = usClock.getPeriodIndicator();

            }case BRLClock brlClock -> this.setHour(brlClock.getHour());
        }
        return this;
    }

    @Override
    public String getTime(){
        return super.getTime() + " " + this.periodIndicator;
    }

}
