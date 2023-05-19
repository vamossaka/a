public class NBody
{
	
	public static double readRadius(String filename)
	{
		In in=new In(filename);
		int N=in.readInt();
		double R=in.readDouble();
		return R;
	}
    public static Planet[] readPlanets(String filename)
    {
       
        In in=new In(filename);
        int num=in.readInt();
        double R=in.readDouble();
        Planet[] allplanets=new Planet[num];
    	for(int i=0;i<num;i+=1)
    	{
    		

    	
    		double xp=in.readDouble();
    		
    		double yp=in.readDouble();
    		
    		double xv=in.readDouble();
    		
    		double yv=in.readDouble();
    	    		
    	    double mass=in.readDouble();
    		
    		String images=in.readString();
    	
    		allplanets[i]=new Planet(xp,yp,xv,yv,mass,images);

    	}
    	return allplanets;
    }	
    public static void main(String[] args)
    {
       double T=Double.parseDouble(args[0]);
       double dt=Double.parseDouble(args[1]);
       String filename=args[2];
       double R=readRadius(filename);
       Planet[] P=readPlanets(filename);
       int n=P.length;
       StdDraw.enableDoubleBuffering();
       StdDraw.setScale(-R,R);
       StdDraw.picture(0,0,"images/starfield.jpg");
      StdDraw.show();
       for(Planet planet : P)
         {planet.draw();}
      double time=0;
      int i=0;
      double[] xForces=new double[n];
      double[] yForces=new double[n];
      for(;time<T;time+=dt)
      {
         for(;i<n;i++)
           { xForces[i]=P[i].calcNetForceExertedByX(P);
            yForces[i]=P[i].calcNetForceExertedByY(P);}
            for(i=0;i<n;i++)
        {P[i].update(dt,xForces[i],yForces[i]);}
      
       StdDraw.picture(0,0,"images/starfield.jpg");
      
      for(Planet planet : P)
         {planet.draw();
      }
      StdDraw.show();
      StdDraw.pause(10);   
       
      }
      StdOut.printf("%d\n", P.length);
StdOut.printf("%.2e\n", R);
for (i = 0; i < P.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  P[i].xxPos, P[i].yyPos,P[i].xxVel,
                  P[i].yyVel, P[i].mass, P[i].imgFileName);   
}
    }
}