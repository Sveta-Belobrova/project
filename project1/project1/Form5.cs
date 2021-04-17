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
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }

        private void label2_Click(object sender, EventArgs e)
        {
           

        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection cann = new SqlConnection();
            cann.ConnectionString = @"Data Source=LAPTOP-11302SKF\SQLEXPRESS;Initial Catalog=project;Integrated Security=True";
            cann.Open();

            SqlCommand myCommand = cann.CreateCommand();

            myCommand.CommandText = "INSERT INTO" + " knigs(name, onic, kod_sc, kod_katerorja, kod_av)  VALUES(@TouristID, @Family, (Select schanrs.kod_sch from schanrs where schanrs.name_sch=@Ris), (Select kater.kod_kater from kater where kater.name_kater=@Gi),(Select avtor.kod_av from avtor  where avtor.name_av=@Gix))";
            myCommand.Parameters.Add("@TouristID", SqlDbType.NVarChar, 50);
            myCommand.Parameters["@TouristID"].Value = this.textBox1.Text;
            myCommand.Parameters.Add("@Family", SqlDbType.NVarChar, 50);
            myCommand.Parameters["@Family"].Value = this.textBox7.Text;
            myCommand.Parameters.Add("@Ris", SqlDbType.NVarChar, 50);
            myCommand.Parameters["@Ris"].Value = this.comboBox2.Text;
            myCommand.Parameters.Add("@Gi", SqlDbType.NVarChar, 50);
            myCommand.Parameters["@Gi"].Value = this.comboBox3.Text;
            myCommand.Parameters.Add("@Gix", SqlDbType.NVarChar, 50);
            myCommand.Parameters["@Gix"].Value = this.comboBox1.Text;
            int UspeshnoeIzmenenie = myCommand.ExecuteNonQuery();
            if (UspeshnoeIzmenenie != 0)
            {
                MessageBox.Show("изменение книги внесены");
            }
            else
            {
                MessageBox.Show("попробуйте еще раз");
            }
            cann.Close();
        }

        private void Form5_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'projectDataSet1.kater' table. You can move, or remove it, as needed.
            this.katerTableAdapter.Fill(this.projectDataSet1.kater);
            // TODO: This line of code loads data into the 'projectDataSet1.schanrs' table. You can move, or remove it, as needed.
            this.schanrsTableAdapter.Fill(this.projectDataSet1.schanrs);
            // TODO: This line of code loads data into the 'projectDataSet1.avtor' table. You can move, or remove it, as needed.
            this.avtorTableAdapter.Fill(this.projectDataSet1.avtor);
            // TODO: This line of code loads data into the 'projectDataSet.avtor' table. You can move, or remove it, as needed.
            this.avtorTableAdapter.Fill(this.projectDataSet1.avtor);
           

        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            openFileDialog1.Filter = "Text files(*.pdf)|*.pdf|All files(*.*)|*.*";
        
        if (openFileDialog1.ShowDialog() == DialogResult.Cancel)
            return;
        // получаем выбранный файл
        string filename = openFileDialog1.FileName;
        // читаем файл в строку
        string fileText = System.IO.File.ReadAllText(filename);
        textBox2.Text = filename;
        MessageBox.Show("Файл открыт");
        
        }
    }
}
