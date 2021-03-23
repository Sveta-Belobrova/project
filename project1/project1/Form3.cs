using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace project1
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void загрузитьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form5 newForm = new Form5();
            newForm.Owner = this;
            newForm.Show();
        }

        private void жанрыToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form7 newForm = new Form7();
            newForm.Owner = this;
            newForm.Show();
        }

        private void авторыToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form6 newForm = new Form6();
            newForm.Owner = this;
            newForm.Show();
        }

        private void категорииToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form8 newForm = new Form8();
            newForm.Owner = this;
            newForm.Show();
        }
    }
}
