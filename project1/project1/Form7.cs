using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
namespace project1
{
    public partial class Form7 : Form
    {
        public Form7()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection cann = new SqlConnection();
            cann.ConnectionString = @"Data Source=LAPTOP-11302SKF\SQLEXPRESS;Initial Catalog=project;Integrated Security=True";
            cann.Open();

            SqlCommand myCommand = cann.CreateCommand();

            myCommand.CommandText = "INSERT INTO" + " schanrs(name_sch, opic)  VALUES(@TouristID, @Gi)";
            myCommand.Parameters.Add("@TouristID", SqlDbType.NVarChar, 50);
            myCommand.Parameters["@TouristID"].Value = this.textBox1.Text;
            myCommand.Parameters.Add("@Gi", SqlDbType.NVarChar, 50);
            myCommand.Parameters["@Gi"].Value = this.textBox7.Text;

            int UspeshnoeIzmenenie = myCommand.ExecuteNonQuery();
            if (UspeshnoeIzmenenie != 0)
            {
                MessageBox.Show("изменение блюда внесены");
            }
            else
            {
                MessageBox.Show("попробуйте еще раз");
            }
            cann.Close();

        }
    }
}
