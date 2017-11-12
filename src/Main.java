import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class Calc
{

    private JFrame window;

    public Calc()
    {

        window = new JFrame("Calculator");
        window.setSize(255, 340);
        window.add(new CalcPanel());
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Calc();

            }
        });


    }

}
