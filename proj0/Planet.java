public class Planet
{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;



	public Planet(double xP,double yP,double xV,double yV,double m,String img)
{
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
}

    public Planet(Planet P)
{

}
    public  double calcDistance(Planet P1){
    	
    	double sum=0;
    	sum=Math.pow(P1.xxPos-this.xxPos,2)+Math.pow(P1.yyPos-this.yyPos,2);
        double result=Math.pow(sum,0.5);
    	return result;

    }
    public double calcForceExertedBy(Planet P2)
    {
    	double force=0;
    	double G=6.67e-11;
    	double distance=this.calcDistance(P2);
    	force=(G*this.mass*P2.mass)/Math.pow(distance,2);
    	return force;
    }
    public double calcForceExertedByX(Planet P3)
    {
    	double forcex=0;
    	forcex=calcForceExertedBy(P3)*(P3.xxPos-this.xxPos)/this.calcDistance(P3);
    	return forcex;
    }
    public double calcForceExertedByY(Planet P4)
    {
    	double forcey=0;
    	forcey=calcForceExertedBy(P4)*(P4.yyPos-this.yyPos)/this.calcDistance(P4);
    	return forcey;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets)
    {
        double netforcex=0;
        
       
        
        
            for(int j=0;j<allPlanets.length;j+=1){
                 if(!this.equals(allPlanets[j])){
                     netforcex+=calcForceExertedByX(allPlanets[j]);
                 }
            }
            
        
        return netforcex;
    }
     public double calcNetForceExertedByY(Planet[] allPlanets)
    {
        double netforcey=0;
       
       
        
            for(int j=0;j<allPlanets.length;j+=1){
                 if(!this.equals(allPlanets[j])){
                     netforcey+=calcForceExertedByY(allPlanets[j]);
                 }
            }
            
        
        return netforcey;
    }
     public void update(double dt,double fx,double fy)
     {
        double ax=0;
        double ay=0;
     
        ax=fx/this.mass;
        ay=fy/this.mass;
        this.xxVel+=dt*ax;
        this.yyVel+=dt*ay;
        this.xxPos+=dt*xxVel;
        this.yyPos+=dt*yyVel;
     }
     public void draw()
     {
        
        StdDraw.picture(xxPos,yyPos,"images/"+ imgFileName);
        StdDraw.show();
     }
}