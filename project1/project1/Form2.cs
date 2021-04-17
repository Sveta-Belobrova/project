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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox6.Text == textBox7.Text)
            {
                SqlConnection cann = new SqlConnection();
                cann.ConnectionString = @"Data Source=LAPTOP-11302SKF\SQLEXPRESS;Initial Catalog=project;Integrated Security=True";
                cann.Open();

                SqlCommand myCommand = cann.CreateCommand();

                myCommand.CommandText = "INSERT INTO" + " pols(famil, name, otes, voz, admit, password, email)  VALUES(@TouristID, @Family, @Ris, @Gi, @Dir, @Six, @Seven)";
                myCommand.Parameters.Add("@TouristID", SqlDbType.NVarChar, 150);
                myCommand.Parameters["@TouristID"].Value = this.textBox1.Text;
                myCommand.Parameters.Add("@Family", SqlDbType.NVarChar, 150);
                myCommand.Parameters["@Family"].Value = this.textBox2.Text;
                myCommand.Parameters.Add("@Ris", SqlDbType.NVarChar, 150);
                myCommand.Parameters["@Ris"].Value = this.textBox3.Text;
                myCommand.Parameters.Add("@Gi", SqlDbType.NVarChar, 150);
                myCommand.Parameters["@Gi"].Value = this.textBox4.Text;
                myCommand.Parameters.Add("@Dir", SqlDbType.NVarChar, 150);
                myCommand.Parameters["@Dir"].Value = this.textBox5.Text;
                myCommand.Parameters.Add("@Six", SqlDbType.NVarChar, 8);
                myCommand.Parameters["@Six"].Value = this.textBox6.Text;
                myCommand.Parameters.Add("@Seven", SqlDbType.NVarChar, 150);
                myCommand.Parameters["@Seven"].Value = this.textBox6.Text;


                int UspeshnoeIzmenenie = myCommand.ExecuteNonQuery();
                if (UspeshnoeIzmenenie != 0)
                {
                    MessageBox.Show("добавление пользователя успешно завершилось");
                }
                else
                {
                    MessageBox.Show("попробуйте еще раз");
                }
                cann.Close();
            }
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }
    }
}
